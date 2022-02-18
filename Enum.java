public class Enum {
    /* 
    Немного о коде:
        Полученный фрагмент кода представляет собой разновидность реализации паттерна Фабрики, 
        который позволяет создавать семейства объектов без привязки к конкретным классам создаваемых объектов.
        Поскольку каждый элемент перечисления по сути является объектом, то мы можем их параметризовать через конструктор.
        Также поля id и name, а также конструктор PhoneDevice должны быть приватными для соблюдения паттерна Фабрика, чтобы
        получение объектов осуществлялось исключительно через статический публичный метод.
    */
    enum PhoneDevice {
        POLYCOM(1, "Polycom"),
        CISCO(2, "Cisco"),
        UNKNOWN(3, "unknown");

        private int id;
        private String name;

        private PhoneDevice(int i, String polycom) {
            this.id = i;
            this.name = polycom;
        }

        public static PhoneDevice byName(String name) {
            for (PhoneDevice d : values()) {
                if (d.name.equals(name)) {
                    return d;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        PhoneDevice device = PhoneDevice.byName("Cisco");
        System.out.println(device);
    }
}
