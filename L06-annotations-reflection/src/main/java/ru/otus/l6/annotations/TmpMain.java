package ru.otus.l6.annotations;

@Default(author = "otus")
public class TmpMain {
    public static void main(String[] args) {
        final Class<TmpMain> tmpMainClass = TmpMain.class;
        final Default aDefault = tmpMainClass.getDeclaredAnnotation(Default.class);
        System.out.println(aDefault.author());
    }
}
