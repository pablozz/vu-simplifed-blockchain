import java.text.SimpleDateFormat;
import java.util.Date;

public class Block {

    private String prevHash;
    private String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


    Block() {

    }
}
