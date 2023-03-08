import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Librarian implements ActionListener {
    String username;
    String password;

    Librarian(){
        username = "dafault";
        password = "dafault";

    }
    Librarian(String username , String password) {
        this.username= username;
        this.password=password;
    }
   static Librarian librarian1 = new Librarian("MOBIN","0912");
    public Librarian(Librarian libarian2) {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}

