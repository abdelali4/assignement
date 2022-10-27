package ma.octo.assignement.AuditOperation.utils;

public enum OperationType {

    TRANSFER("transfer"),
    DEPOSIT("Deposit d'argent");

    private String type;

    OperationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
