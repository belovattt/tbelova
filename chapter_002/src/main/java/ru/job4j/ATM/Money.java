package ru.job4j.ATM;
/**
 * Class Money решение задачи ATM.
 *
 * @author Tatyana Belova
 * @since 23.08.2017
 */

public class Money {
    /**
     * список имеющихся монет
     */
    private int[] bonds;
    /**
     * размениваемая купюра
     */
    private int cash;
    /**
     * варианты размена
     */
    private StringBuffer answer = new StringBuffer();
    /**
     * конструктор.
     * @param bonds - список монет
     * @param cash - купюра
     */
    Money(int[] bonds, int cash) {
        this.bonds = bonds;
        this.cash = cash;
    }
    /**
     * метод переводит ответ из StringBuffer в String
     * @return ответ
     */

   public String getAnswer() {
        return this.answer.toString();
    }
    /**
     * метод запускает рекурсию.
     */
    void init() {
        new Rec("", 0, 0).exchange();
    }

    /**
     * класс Rec для организации рекурсивного поиска всех вариантов размена.
     */
    class Rec {
        /**
         * один вариант размена
         */
        String summa;
        /**
         * сумма монет в summa
         */
        int itogo;
        /**
         * с какой позиции начинаем перебирать массив bonds
         */
        int position;
        /**
         * конструктор.
         * @param summa - summa
         * @param itogo - itogo
         * @param position - position
         */
        Rec(String summa, int itogo, int position) {
            this.summa = summa;
            this.itogo = itogo;
            this.position = position;
        }
        /**
         * рекурсивный метод.
         * если набранная сумма монет меньше требуемой, продолжаем рекурсию.
         * если набранная сумма равна требуемой, summa присоединяем к ответу
         */

        void exchange() {
            if (itogo < cash) {
                for (int i = position; i < bonds.length; i++) {

                    new Rec(this.summa + bonds[i], this.itogo + bonds[i], i).exchange();
                }
            }
            if (itogo == cash) {
                answer.append(summa);
                answer.append(" ");
            };
        }

    }
}

