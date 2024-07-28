public class AstonWork {
    public static void main (String[]args){
     printThreeWords();
     checkSumSign();
     printColor();
     compareNumbers();
     isSumm(15,2);
     checkRationality(-2);
     isPositive(-5);
     numberLine("string", 5);
     leapYear(2100);
     anIntegerArray();
     emptyArray();
     integerArray();
     diagonalArray();
     getArray(3, 423);
    }

    // 1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
    public static void printThreeWords() {
     System.out.println("Orange");
     System.out.println("Banana");
     System.out.println("Apple"); 
    }

    // 2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями,
    // которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
    // в противном случае - “Сумма отрицательная”;
    public static void checkSumSign() {
        int a = 2;
        int b = 5; 
        if (a+b >= 0){
        System.out.println("Сумма положительная");
      } else {
        System.out.println("Сумма отрицательная");
      }
    }
     
    // 3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением. Если value меньше 0 (0 включительно),
    // то в консоль метод должен вывести сообщение “Красный”,если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
    // если больше 100 (100 исключительно) - “Зеленый”;
    public static void printColor() {
        int value = 111;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100){
            System.out.println("Зеленый");
        }
    }

    // 4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями,
    //  которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    public static void compareNumbers() {
        int a = 50;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else  {
            System.out.println("a < b");
        }

    }
        
    // 5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), 
    // если да – вернуть true, в противном случае – false.
    public static boolean isSumm(int a, int b) {
       return a+b >= 10 && a+b <= 20;
    }  
     
    // 6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, 
    // положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void checkRationality(int a){
        if (a < 0) {
          System.out.println("Отрицательное");
       } else if (a >= 0){
          System.out.println("Положительное");
       }
    }

    // 7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, 
    // и вернуть false если положительное.Замечание: ноль считаем положительным числом.
    public static boolean isPositive(int a){
        return a < 0;
    }   
    
    // 8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
    public static void numberLine(String n, int a){
        for (int b = 1; b <= a; b++) {
        System.out.println(n);
        }
    }
    
    // 9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). 
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean leapYear(int a){
        if ( a % 4 == 0 && a % 100 != 0){
            return true;
        }  else if (a % 400 == 0) {
            return true;
        }
           return false;
    }

    // 10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void anIntegerArray(){
        int[] arr = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0) {
             arr[i] = 1;
            } else if (arr[i] == 1) {
                arr[i] = 0;
            }
        }         
    } 
    
    // 11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
    public static void emptyArray(){
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
         arr[i] = i + 1;
        }
    }

    // 12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void integerArray(){
        int[] arr = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6 ) {
                arr[i] = arr[i] * 2;
            } 
          
        }
    }

    // 13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы 
    // единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, 
    // то есть [0][0], [1][1], [2][2], ..., [n][n];
    public static void diagonalArray () {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }
    }

    // 14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
    public static int[] getArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return  arr;
    }
}

