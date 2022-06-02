package DataStructure.SequenceList;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/5 17:53
 * @description :
 */
public class Test {
    public static void main(String[] args) {
        SquenceList<String> strList01 = new SquenceList<>(1);
        strList01.insert("A");
        strList01.insert("B");
        strList01.insert("C");
        strList01.insert(1, "D");
        String get = strList01.get(1);
        System.out.println("strList01.get(1): "+get);
        String remove = strList01.remove(1);
        System.out.println("strList01.remove(1): "+remove);
        for (String s:strList01){
            System.out.println(s);
        }
//        int length = strList01.length();
        System.out.println(strList01.length());
        strList01.clear();
        System.out.println("strList01.clear(): "+strList01.length());
    }
}
