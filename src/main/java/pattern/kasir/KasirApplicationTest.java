package pattern.kasir;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

// import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KasirApplicationTest {

  //untuk log4j2
  //  private static final Logger logger = LogManager.getLogger(KasirApplicationTest.class);

  //untuk logback
  private static final Logger logger = LoggerFactory.getLogger(
    KasirApplicationTest.class
  );

  public static void main(String[] args) {
    logger.info("hahahaha");
    logger.debug("hahahaha");
    logger.error("hahahaha");
    logger.warn("hahahaha");
    //        logger.fatal("hahahaha");
    logger.trace("hahahaha");
    //        System.out.println(System.currentTimeMillis());
    //        String strEncrypt =Crypto.performEncrypt("HelloForm.C12."+System.currentTimeMillis());
    //        String strEncrypt ="d9fddb00e945a1a8d010d949e622a090839866f758c0a93810d6015278fac667";
    //        System.out.println(strEncrypt);
    //        String strDecrypt=Crypto.performDecrypt(strEncrypt);
    //        System.out.println(strDecrypt);
    //        System.out.println(Instant.now());
    //        String [] strArr =strDecrypt.split("\\.");
    //        for (int i = 0; i < strArr.length; i++) {
    //            System.out.println(strArr[i]);
    //        }
    //        System.out.println((System.currentTimeMillis()-(Long.parseLong(strArr[2])))/1000);
    //        System.out.println(strArr[0]);
    //        System.out.println((UUID.randomUUID()).toString().replaceAll("-", ""));
  }
}
