package demo.jsf_spring_app.presentation.tabs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.event.ActionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.component.tree.IceUserObject;

import demo.jsf_spring_app.model.File;
import demo.jsf_spring_app.presentation.DirFileObject;
import demo.jsf_spring_app.presentation.SessionBean;
import demo.jsf_spring_app.presentation.utils.JSFUtil;
import demo.jsf_spring_app.presentation.utils.SpringUtil;

public class FisiereBean {

	private DefaultMutableTreeNode directorCurent;

	public String getDir() {
		if (directorCurent != null) {
			return ((IceUserObject) directorCurent.getUserObject()).getText();
		} else {
			return "-";
		}
	}

	private String director;

	private int fileProgress;

	private DefaultTreeModel model;
	private boolean modelNotNull = false;

	// default node icons for xp thme
	private static final String XP_BRANCH_CONTRACTED_ICON = "./xmlhttp/css/xp/css-images/tree_folder_open.gif";
	private static final String XP_BRANCH_EXPANDED_ICON = "./xmlhttp/css/xp/css-images/tree_folder_close.gif";
	private static final String XP_BRANCH_LEAF_ICON = "./xmlhttp/css/xp/css-images/tree_document.gif";

	public FisiereBean() {
	}

	public DefaultTreeModel getModel() {
		return model;
	}

	public String creaza() {
		System.out.println("creaza");

		if (model == null) {
			DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode();
			DirFileObject rootObject = new DirFileObject(rootTreeNode);
			rootObject.setText(director);
			rootObject.setExpanded(true);
			rootObject.setLeaf(false);
			rootObject.setBranchContractedIcon(XP_BRANCH_CONTRACTED_ICON);
			rootObject.setBranchExpandedIcon(XP_BRANCH_EXPANDED_ICON);
			rootObject.setLeafIcon(XP_BRANCH_LEAF_ICON);
			rootObject.setDirectory(rootTreeNode);
			rootTreeNode.setUserObject(rootObject);
			model = new DefaultTreeModel(rootTreeNode);
			modelNotNull = true;
		} else {
			if (directorCurent == null) {
				addNode((DefaultMutableTreeNode) model.getRoot(), director,
						null);
			} else {
				addNode(directorCurent, director, null);
			}
		}
		return null;
	}

	private DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent,
			String text, String filePath) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode();
		DirFileObject userObject = new DirFileObject(node);
		node.setUserObject(userObject);

		userObject.setText(text);

		userObject.setBranchContractedIcon(XP_BRANCH_CONTRACTED_ICON);
		userObject.setBranchExpandedIcon(XP_BRANCH_EXPANDED_ICON);
		userObject.setLeafIcon(XP_BRANCH_LEAF_ICON);

		if (filePath != null) {
			userObject.setLeaf(true);
			userObject.setFilePath(filePath);
			userObject.setExpanded(true);
			node.setAllowsChildren(false);
			userObject.setDirectory(parent);
		} else {
			userObject.setLeaf(false);
			node.setAllowsChildren(true);
			userObject.setDirectory(node);
		}

		if (parent != null) {
			parent.add(node);
		}

		return node;
	}

	public void uploadFile(ActionEvent event) {
		if (directorCurent != null) {
			InputFile inputFile = (InputFile) event.getSource();
			FileInfo fileInfo = inputFile.getFileInfo();
			if (fileInfo.getStatus() == FileInfo.SAVED) {
				addNode(directorCurent, fileInfo.getFileName(), fileInfo
						.getPhysicalPath());

				String userName = ((SessionBean) JSFUtil
						.getBean(SessionBean.class.getSimpleName()))
						.getLoggedInUser().getUserName();

				File file = new File();
				file.setFileName(fileInfo.getFileName());
				file.setFilePath(fileInfo.getPhysicalPath());
				file.setSize(fileInfo.getSize());
				try {
					file.setContent(getBytesFromFile(inputFile.getFileInfo().getFile()));
					SpringUtil.getServices().addFileToUser(userName, file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	// Returns the contents of the file in a byte array.
    public static byte[] getBytesFromFile(java.io.File file) throws IOException {
        InputStream is = new FileInputStream(file);
    
        // Get the size of the file
        long length = file.length();
    
        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
    
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];
    
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
    
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }
    
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }


	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getFileProgress() {
		return fileProgress;
	}

	public void setFileProgress(int fileProgress) {
		this.fileProgress = fileProgress;
	}

	public void setModel(DefaultTreeModel model) {
		this.model = model;
	}

	public void setDirectorCurent(DefaultMutableTreeNode directorCurent) {
		this.directorCurent = directorCurent;
	}

	public DefaultMutableTreeNode getDirectorCurent() {
		return directorCurent;
	}

	public void setModelNull(boolean modelNull) {
		this.modelNotNull = modelNull;
	}

	public boolean isModelNull() {
		return modelNotNull;
	}
}
