package youareell;

import controllers.*;
import views.IdTextView;

public class YouAreEll {

    private MessageController msgCtrl;
    private IdController idCtrl;
    private TransactionController transCtrl;

    public YouAreEll () {
        // used j because i seems awkward
        this.transCtrl = new TransactionController();
        this.idCtrl = new IdController(transCtrl);

    }

//    public static void main(String[] args) {
//        // hmm: is this Dependency Injection?
//        YouAreEll urlhandler = new YouAreEll();
////        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
////        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
//    }

    public String get_ids() {
//        return MakeURLCall("/ids", "GET", "");
        return new IdTextView().toString(idCtrl.getIds());
    }

    public String get_messages() {
//        return MakeURLCall("/messages", "GET", "");
        return null;
    }


}
