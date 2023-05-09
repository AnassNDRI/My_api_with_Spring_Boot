package ipeps.pwd.wallet.module.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                // Permet de créer dynamiquement les getter et setter
@AllArgsConstructor  // constructeur avec tous les paramètres
@NoArgsConstructor   // constructeur vide

// cette classe est utilisée pour la requete de recherche
public class SearchAccountPayload {
        private String entity;
        private int id;
        private String full;

}
