package pengolahandataproduksi;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pengolahandataproduksi.model.TblUsers;

public class PengolahanDataProduksi {

    public static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PengolahanDataProduksiPU");
    public static TblUsers USER = new TblUsers();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
