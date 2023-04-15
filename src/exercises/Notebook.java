package exercises;

import java.util.regex.*;

public class Notebook {


    /**
     * Конструктор класса Notebook
     *
     * @param strToParse Заголовок с описанием с сайта dns
     */
    public Notebook(String strToParse) {
        // генерируем цену от 0 до 1000
        setPrice(Math.random() * 1000);
        brand = findRegex(strToParse, "(?<=Ноутбук\\s)[a-zA-Z]*(?=\\s)");
        model = findRegex(strToParse, "(?<=" + brand + "\\s).*(?=\\s[а-я]*\\s\\[)");
        color = findRegex(strToParse, "(?<=\\s)[а-яА-Я]*(?=\\s\\[)");
        size = Double.parseDouble(findRegex(strToParse, "[0-9]{1,2}.?[0-9]?(?=\\\")"));
        String[] paramsRAW = findRegex(strToParse, "(?<=\\[).*(?=\\])").split(", ");
        resolution = paramsRAW[0];
        matrixType = paramsRAW[1];
        cpuFamily = paramsRAW[2];
        System.out.println(paramsRAW[3]);
        cpuCores = Integer.parseInt(findRegex(paramsRAW[3], "(?<=ядра\\:\\s)[0-9]{1,2}(?=\\sх)"));
        cpuFrequency = Double.parseDouble(findRegex(paramsRAW[3], "(?<=х\\s).*(?=\\sГГц)"));
        volRAM = Integer.parseInt(findRegex(paramsRAW[4], "(?<=RAM\\s)[0-9]{1,3}(?=\\sГБ)"));
        typeHDD = findRegex(paramsRAW[5], "[a-zA-Z]{1,}");
        volHDD = Integer.parseInt(findRegex(paramsRAW[5], "[0-9]{1,}"));
        videoAdaptor = paramsRAW[6];
        osPreinstall = paramsRAW[7];
    }

    /**
     * Назначение цены
     *
     * @param inPrice Цена
     */
    public void setPrice(Double inPrice) {
        price = inPrice;
    }

    /**
     * Поиск по разрешению
     *
     * @param inResolution строка с необходимым разрешением, например "1920x1080" или требуемый формат, например "Full HD"
     * @return
     */
    public Boolean isMatchResolution(String inResolution) {
        return findStr(resolution, inResolution);
    }

    /**
     * Поиск по типу процессора
     *
     * @param inCpu можно указать семейство, марку, вендора
     * @return
     */
    public Boolean isMatchCPUType(String inCpu) {
        return findStr(cpuFamily, inCpu);
    }

    /**
     * Поиск по виду ОС
     *
     * @param inOS
     * @return
     */
    public Boolean isMatchOSType(String inOS) {
        return findStr(osPreinstall, inOS);
    }

    /**
     * Поиск по ценовому диапазону
     *
     * @param minPrice Минимальная граница
     * @param maxPrice Максимальная граница
     * @return
     */
    public Boolean isMatchPrice(Double minPrice, Double maxPrice) {
        return price >= minPrice && price <= maxPrice;
    }

    /**
     * Поиск по объему ОЗУ
     *
     * @param minRAM Минимальная граница
     * @param maxRAM Максимальная граница
     * @return
     */
    public Boolean isMatchRAM(Integer minRAM, Integer maxRAM) {
        return volRAM >= minRAM && volRAM <= maxRAM;
    }

    /**
     * Поиск регулярного выражения в строке
     *
     * @param inStr
     * @param regex
     * @return
     */
    private String findRegex(String inStr, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inStr);
        return matcher.find() ? matcher.group() : "";
    }

    /**
     * Проверка наличия в строке par содержимого inStr
     *
     * @param par
     * @param inStr
     * @return
     */
    private Boolean findStr(String par, String inStr) {
        Pattern pattern = Pattern.compile(inStr.replace(" ", "").toLowerCase());
        Matcher matcher = pattern.matcher(par.replace(" ", "").toLowerCase());
        return matcher.find();
    }

    private Double price; // цена
    private String brand; // бренд
    private String model; // модель
    private String color; // цвет
    private Double size; // диагональ
    private String resolution; // разрешение
    private String matrixType; // тип матрицы
    private String cpuFamily; // марка ЦПУ
    private Integer cpuCores; // количество ядер
    private Double cpuFrequency; // частота ЦПУ
    private Integer volRAM; // объем оперативной памяти
    private String typeHDD; // тип накопителя
    private Integer volHDD; // объем накопителя
    private String videoAdaptor; // марка видеокарты
    private String osPreinstall; // операционная система

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
