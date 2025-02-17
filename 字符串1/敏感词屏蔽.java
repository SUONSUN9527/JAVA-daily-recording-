package 字符串1;

public class 敏感词屏蔽 {
    public static void main(String[] args) {
        String talk = "你玩的真好TMD,你个SB，MLGB的，我CNM";
        String result = talk.replace("TMD","xxx");
        String[] dirty = {"TMD","CNM","SB","MLGB"};
        for (int i = 0; i < dirty.length; i++) {
            talk = talk.replace(dirty[i],"xxx");
        }
        System.out.println(talk);
    }
}
