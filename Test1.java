//Считать из файла последовательность целых чисел. Вычислить 90 персентиль, медиану, максимальное, минимальное и среднее значения. 
//На вход программа получает файл с числами. Каждое число в файле находится на новой строке. Вывод в консоль должен быть следующим:
//
//90 percentile <значение>
//median <значение>
//average <значение>
//max <значение>
//min <значение> 
package test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Александр Машьянов, mashyanov1987@gmail.com, +7(981)784-79-67
 */
public class Test1 {
    public static void main(String[] args) {
        try {
        File file = new File(JOptionPane.showInputDialog("Введите путь к файлу данных", "test.txt"));
        if(!file.exists()) throw new FileNotFoundException("File was not found");
        
        else{
            /**Коллекция, которая будет содержать все данные из файла*/
            ArrayList<Integer> data = new ArrayList<>();
            /**Считываем из файла данные, пока они не закончатся*/
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext())
                data.add(scanner.nextInt());
            /**Сортируем коллекцию по возрастанию, создавая лёгенький Компаратор*/
            data.sort((Integer int1, Integer int2) -> int1-int2);
            /**Будет содержать сумму всех элементов коллекции*/
            int summOfCollection = 0;
            /**Считаем эту сумму*/
            for (Integer integer : data) 
                summOfCollection +=integer;
                   
            System.out.println("percentile " + data.get((int)Math.ceil(90/100) * data.size()));
            System.out.println("median " + (data.size()%2 !=0 ? String.valueOf(data.get(data.size()/2)) : 
                    String.valueOf((float)(data.get(data.size()/2 - 1) +data.get(data.size()/2))/2)));
            System.out.println("average " + (float)summOfCollection/data.size());
            System.out.println("max " + data.get(data.size()-1));
            System.out.println("min " + data.get(0));
        }} catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JPanel(), "FileNotFoundException:\n" + ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            System.err.println("FileNotFoundException:" + ex.getMessage());
        }}}       
    