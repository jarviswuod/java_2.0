// 3. Method Chaining (Fluent Interface)

public class _31__ThisKeywordExample_3 {
    public static void main(String[] args) {

        // Usage:
        StringBuilder sb = new StringBuilder()
                .append("Hello")
                .append(" ")
                .append("World")
                .reverse();
        System.out.println(sb);
    }
}

class StringBuilder {
    private String content = "";

    public StringBuilder append(String text) {
        this.content += text;
        return this; // Returns current object for chaining
    }

    public StringBuilder reverse() {
        this.content = new java.lang.StringBuilder(this.content).reverse().toString();
        return this;
    }

    public String build() {
        return this.content;
    }

    @Override
    public String toString() {
        return "StringBuilder [content=" + content + "]";
    }
}
