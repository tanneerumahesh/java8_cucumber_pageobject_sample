package ebay.qa.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class FactoryUtils {

    public static String ConfigValue(String ConfigKey){

        ResourceBundle rb = ResourceBundle.getBundle("ebay.qa.test.config");
        return rb.getString(ConfigKey);
    }

    public static boolean IsNullOremply(String text){

        return text == null || text.length() == 0;
    }

    public static Integer Random(int min,int max){
        Random r = new Random();
        return r.nextInt(max-min) + min;
    }

    public static boolean IsSorted(List<BigDecimal> clist, String sortorder){

        boolean result=true;
        BigDecimal i= BigDecimal.valueOf(0);

        if (sortorder.equals("asc")){
        for (BigDecimal e : clist )
        {
            if (e.compareTo(i)>=0){
                i=e;
            }else {
                result = false;
                break;
            }
        }
        }
        else if (sortorder.equals("desc"))
        {
            for (BigDecimal e : clist )
            {
                if (e.compareTo(i)>=0){
                    i=e;
                }else {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
