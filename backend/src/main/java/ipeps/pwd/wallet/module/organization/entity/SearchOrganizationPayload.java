package ipeps.pwd.wallet.module.organization.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                // Permet de créer dynamiquement les getter et setter
@AllArgsConstructor  // constructeur avec tous les paramètres
@NoArgsConstructor   // constructeur vide


public class SearchOrganizationPayload {
    private String entity;
    private int id;
    private String full;
}
