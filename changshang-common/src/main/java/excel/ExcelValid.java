package excel;

/**
 * @Author ming.jin
 * @Date 2017/8/10
 */
@FunctionalInterface
public interface ExcelValid<T> {
    String valid(T t);
}
