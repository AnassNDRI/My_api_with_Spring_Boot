package ipeps.pwd.wallet.module.transaction.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                // Permet de créer dynamiquement les getter et setter
@AllArgsConstructor  // constructeur avec tous les paramètres
@NoArgsConstructor   // constructeur vide

public class SearchTransactionPayload {
    private String entity;
    private int id;
    private String full;
}
