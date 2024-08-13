
class TwoDimensionalArray {

    static int[][] resultArr;

    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "5", "3"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            resultArr = ArrayConversion(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[][] ArrayConversion(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (!isIquelLength(arr)) {
            throw new MyArraySizeException();
        }

        resultArr = new int[arr.length][arr[0].length];
        int sum = 0;
        for (int i = 0; i < resultArr.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < resultArr[i].length; j++) {
                try {
                    resultArr[i][j] = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
                rowSum += resultArr[i][j];
                System.out.println(resultArr[i][j]);
                sum += rowSum;
            }
            System.out.println();
        }
        System.out.println("Сумма элементов массива: " + sum);
        return resultArr;
    }

    public static boolean isIquelLength(String[][] arr) {
        if (arr.length != 4) {
            return false;
        }
        for (String[] arr1 : arr) {
            if (arr1.length != 4) {
                return false;
            }
        }
        return true;
    }

}
