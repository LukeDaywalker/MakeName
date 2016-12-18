package com.luke.makename.word;


/**汉字五行笔画类
 */
public class MetaLibItem {

    private int stork;//笔画
    private String words;
    private String five;//五行

    /**
     *
     * @param stork 笔画
     * @param five 五行顺序
     * @param words //汉字列
     */
    public MetaLibItem(int stork, String five, String words) {
        this.stork = stork;
        this.five = five;
        this.words = words;
    }

    /**
     *
     * @return 获得笔画
     */
    public int getStork() {
        return this.stork;
    }

    /**
     * 获得汉字列
     *
     * @return
     */
    public String getWords() {
        return this.words;
    }

    /**
     * 获得汉字是否存在列表中
     *
     * @return
     */
    public Boolean isWordExist(String word) {
        if (this.words.indexOf(word) == -1) {
            return false;
        }
        return true;
    }
    
      /**
     * 获得汉字是否存在列表中
     *
     * @return
     */
    public Boolean isWordExist(char word) {
        if (this.words.indexOf(word) == -1) {
            return false;
        }
        return true;
    }

    /**
     * 获得五行
     *
     * @return
     */
    public String getFive() {
        return this.five;
    }
}
