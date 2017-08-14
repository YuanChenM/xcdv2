import org.junit.Before;
import org.junit.Test;

import com.framework.number.generate.NumberGenerateManager;
import com.framework.number.generate.database.redis.properties.RedisParam;
import com.framework.number.generate.database.redis.properties.RedisProperties;

/**
 * Created by zhu_kai1 on 2016/11/15.
 */
public class TestNumberGenerate {

    @Before
    public void before(){
        RedisParam redisParam = new RedisParam();
        redisParam.setHost("10.20.16.152");
        redisParam.setPort(6379);
        redisParam.setPassword("Admin123#");
        redisParam.setDatabase(1);
        redisParam.setTimeout(1000);
        RedisProperties.setRedisProperties(redisParam);
    }


    /**
     * 获取自增长ID
     */
    @Test
    public void  getSequences(){
        System.out.println( NumberGenerateManager.sequences("SO"));
    }

    /**
     * 获取指定长度的编码
     **/
 /* @Test
   public void  getSequencesLength(){
       String code =  NumberGenerateManager.sequences("PD", 10);
        System.out.println(code);
    }*/


    /**
     * 获取指定重置的业务编码
     **/
 /* @Test
    public void getSequenceResetType(){
        System.out.println(NumberGenerateManager.sequences("PD", ResetType.mm));
    }*/

    /**
     * 获取指定重置、长度业务编码
     */
   /* @Test
    public void getSequenceResetType(){
        System.out.println(NumberGenerateManager.sequences("OD", ResetType.RESET_TYPE_MINUTES,10));
    }
*/
   /* @Test
    public void getSeq(){
        System.out.println(NumberGenerateManager.sequences("OD",10,"$$$"));
    }*/
    
//    @Test
//    public void getTimestamp(){
//        System.out.println(NumberGenerateManager.timestamp("sk",null,30));
//    }
  /*  @Test
    public void getTimestamp(){
        System.out.println(NumberGenerateManager.timestamp("OD",DateUtils.FORMAT_YYMMDDHHMM,20,ResetType.mm));
    }*/
}
