package until;

import java.lang.reflect.Field;

public class ReflectUtil {



    public static String json(Object obj){
        Class c=obj.getClass();
        StringBuffer str=new StringBuffer("{");
        Field[] fields=c.getDeclaredFields();
        try {
            for (int i=0;i<fields.length;i++){
                Field field=fields[i];
                field.setAccessible(true);
                String name=field.getName();
                Object value=field.get(obj);
                str.append("\"");
                str.append(name);
                str.append("\":");
                str.append("\"");
                str.append(value);
                str.append("\"");
                if(i<fields.length-1){
                    str.append(",");

                }


            }
            str.append("}");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return str.toString();


    }
}
