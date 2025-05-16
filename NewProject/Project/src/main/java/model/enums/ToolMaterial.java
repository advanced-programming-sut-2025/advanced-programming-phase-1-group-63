package model.enums;

public enum ToolMaterial implements Material {
    Primary,
    Cooper,
    Silver,
    Gold,
    Iridium;


    @Override
    public ToolMaterial upgrade() {
        switch (this) {
            case Primary:
                return Cooper;
            // TODO
        }
        return null;
    }
}


