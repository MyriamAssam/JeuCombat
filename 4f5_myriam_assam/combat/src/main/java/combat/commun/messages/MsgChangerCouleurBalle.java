package combat.commun.messages;

import ca.ntro.app.messages.Message;

public class MsgChangerCouleurBalle extends Message {
    private String codeCouleur;

    public String getCodeCouleur() {
        return codeCouleur;
    }

    public void setCodeCouleur(String codeCouleur) {
        this.codeCouleur = codeCouleur;
    }
}