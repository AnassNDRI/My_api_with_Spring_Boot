package ipeps.pwd.wallet.module.document.entity;

public class UpdateDocumentPayload {
    private int document_id;
    private String name;
    private String description;
    private boolean free_access;
    private String path;
    private String type;

    public UpdateDocumentPayload(int document_id, String name, String description, boolean free_access, String path, String type) {
        this.document_id = document_id;
        this.name = name;
        this.description = description;
        this.free_access = free_access;
        this.path = path;
        this.type = type;
    }

    public UpdateDocumentPayload(){

    }

    public int getDocument_id() {return document_id;}

    public void setDocument_id(int document_id) {this.document_id = document_id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public boolean isFree_access() {return free_access;}

    public void setFree_access(boolean free_access) {this.free_access = free_access;}

    public String getPath() {return path;}

    public void setPath(String path) {this.path = path;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}
}
