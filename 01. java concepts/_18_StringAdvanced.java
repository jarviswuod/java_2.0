public class _18_StringAdvanced {

    // STRING POOL INTERNALS AND MEMORY OPTIMIZATION
    public static void stringPoolInternals() {
        System.out.println("=== STRING POOL INTERNALS ===");

        // String literals go to string pool
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo"; // Compile-time concatenation -> pool

        // Constructor creates new objects in heap
        String s4 = new String("Hello");
        String s5 = new String("Hello");

        // Runtime concatenation -> heap
        String prefix = "Hel";
        String s6 = prefix + "lo";

        // Interning moves heap strings to pool
        String s7 = s6.intern();

        System.out.println("s1 == s2: " + (s1 == s2)); // true - same pool reference
        System.out.println("s1 == s3: " + (s1 == s3)); // true - compile-time optimization
        System.out.println("s1 == s4: " + (s1 == s4)); // false - different objects
        System.out.println("s4 == s5: " + (s4 == s5)); // false - different heap objects
        System.out.println("s1 == s6: " + (s1 == s6)); // false - runtime concatenation
        System.out.println("s1 == s7: " + (s1 == s7)); // true - intern() returns pool reference

        // Memory addresses for visualization
        System.out.println("\nMemory addresses (identity hash codes):");
        System.out.println("s1 (pool): " + System.identityHashCode(s1));
        System.out.println("s2 (pool): " + System.identityHashCode(s2));
        System.out.println("s4 (heap): " + System.identityHashCode(s4));
        System.out.println("s5 (heap): " + System.identityHashCode(s5));
        System.out.println("s6 (heap): " + System.identityHashCode(s6));
        System.out.println("s7 (pool): " + System.identityHashCode(s7));
    }

    // STRINGBUILDER CAPACITY MANAGEMENT AND OPTIMIZATION
    public static void stringBuilderOptimization() {
        System.out.println("\n=== STRINGBUILDER CAPACITY OPTIMIZATION ===");

        // Default capacity analysis
        StringBuilder sb1 = new StringBuilder();
        System.out.println("Default capacity: " + sb1.capacity());

        // Capacity growth demonstration
        StringBuilder sb2 = new StringBuilder(5);
        System.out.println("Initial capacity: " + sb2.capacity());

        for (int i = 0; i < 10; i++) {
            sb2.append("x");
            System.out.println("Length: " + sb2.length() + ", Capacity: " + sb2.capacity());
        }

        // Optimal capacity setting
        int estimatedSize = 1000;
        StringBuilder optimized = new StringBuilder(estimatedSize);
        System.out.println("Pre-allocated capacity: " + optimized.capacity());

        // Capacity growth formula: (oldCapacity * 2) + 2
        System.out.println("Growth formula: (oldCapacity * 2) + 2");

        // Memory efficiency
        StringBuilder sb3 = new StringBuilder(1000);
        sb3.append("Small string");
        System.out.println("Before trimToSize - Capacity: " + sb3.capacity() + ", Length: " + sb3.length());
        sb3.trimToSize();
        System.out.println("After trimToSize - Capacity: " + sb3.capacity() + ", Length: " + sb3.length());
    }

    // THREAD SAFETY DEEP DIVE
    public static void threadSafetyAnalysis() {
        System.out.println("\n=== THREAD SAFETY ANALYSIS ===");

        // Thread-unsafe StringBuilder
        StringBuilder unsafeBuilder = new StringBuilder();

        // Thread-safe StringBuffer
        StringBuffer safeBuffer = new StringBuffer();

        // Demonstrating thread safety issues (conceptual)
        System.out.println("StringBuilder: Not thread-safe");
        System.out.println("- Methods are NOT synchronized");
        System.out.println("- Multiple threads can corrupt internal state");
        System.out.println("- Faster in single-threaded environments");

        System.out.println("\nStringBuffer: Thread-safe");
        System.out.println("- All methods are synchronized");
        System.out.println("- Safe for concurrent access");
        System.out.println("- Slower due to synchronization overhead");

        // Alternative: External synchronization
        StringBuilder externalSync = new StringBuilder();
        synchronized (externalSync) {
            externalSync.append("Thread-safe operation");
        }

        System.out.println("\nAlternative: External synchronization on StringBuilder");
        System.out.println("- Manual synchronization when needed");
        System.out.println("- More control over locking granularity");
    }

    // PERFORMANCE BENCHMARKING
    public static void performanceBenchmark() {
        System.out.println("\n=== PERFORMANCE BENCHMARK ===");

        int iterations = 50000;
        String baseString = "test";

        // String concatenation (O(n²) complexity)
        long startTime = System.nanoTime();
        String result1 = "";
        for (int i = 0; i < iterations; i++) {
            result1 += baseString;
        }
        long stringTime = System.nanoTime() - startTime;

        // StringBuilder (O(n) amortized complexity)
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder(iterations * baseString.length());
        for (int i = 0; i < iterations; i++) {
            sb.append(baseString);
        }
        String result2 = sb.toString();
        long sbTime = System.nanoTime() - startTime;

        // StringBuffer (O(n) amortized complexity + synchronization)
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer(iterations * baseString.length());
        for (int i = 0; i < iterations; i++) {
            sbf.append(baseString);
        }
        String result3 = sbf.toString();
        long sbfTime = System.nanoTime() - startTime;

        System.out.println("Performance Results (nanoseconds):");
        System.out.println("String concatenation: " + stringTime);
        System.out.println("StringBuilder: " + sbTime);
        System.out.println("StringBuffer: " + sbfTime);

        System.out.println("\nPerformance Ratios:");
        System.out.println("StringBuilder vs String: " + (stringTime / sbTime) + "x faster");
        System.out.println("StringBuffer vs String: " + (stringTime / sbfTime) + "x faster");
        System.out.println("StringBuilder vs StringBuffer: " + (sbfTime / sbTime) + "x faster");

        // Memory allocation analysis
        System.out.println("\nMemory Allocation Analysis:");
        System.out.println("String concatenation: O(n²) space complexity");
        System.out.println("StringBuilder/StringBuffer: O(n) space complexity");
    }

    // ADVANCED STRING MANIPULATION TECHNIQUES
    public static void advancedManipulation() {
        System.out.println("\n=== ADVANCED STRING MANIPULATION ===");

        // Efficient string reversal
        StringBuilder sb = new StringBuilder("Hello World");
        sb.reverse();
        System.out.println("Reversed: " + sb);

        // Character manipulation
        StringBuilder charManip = new StringBuilder("Java Programming");
        charManip.setCharAt(0, 'j'); // Change first character
        charManip.insert(5, "Script"); // Insert at specific position
        charManip.delete(9, 15); // Delete range
        System.out.println("Manipulated: " + charManip);

        // Substring operations without creating new objects
        StringBuilder original = new StringBuilder("The quick brown fox jumps over the lazy dog");
        CharSequence subsequence = original.subSequence(10, 19);
        System.out.println("Subsequence: " + subsequence);

        // Efficient search and replace
        StringBuilder text = new StringBuilder("Hello Hello Hello");
        int index = text.indexOf("Hello");
        while (index != -1) {
            text.replace(index, index + 5, "Hi");
            index = text.indexOf("Hello", index + 2);
        }
        System.out.println("After replace: " + text);
    }

    // MEMORY LEAK SCENARIOS AND PREVENTION
    public static void memoryLeakScenarios() {
        System.out.println("\n=== MEMORY LEAK SCENARIOS ===");

        // Scenario 1: Excessive String interning
        System.out.println("Scenario 1: Excessive String interning");
        System.out.println("- Avoid interning runtime-generated strings");
        System.out.println("- Pool grows indefinitely until GC");
        System.out.println("- Example: user.getName().intern() // DON'T DO THIS");

        // Scenario 2: Large StringBuilder/StringBuffer retention
        System.out.println("\nScenario 2: Large StringBuilder retention");
        StringBuilder largeBuilder = new StringBuilder(10000);
        largeBuilder.append("small content");
        // Problem: large capacity retained even for small content
        System.out.println("Large capacity: " + largeBuilder.capacity());
        System.out.println("Small length: " + largeBuilder.length());

        // Solution: trim or create new string
        String optimized = largeBuilder.toString(); // New string with exact size
        largeBuilder = null; // Release large buffer
        System.out.println("Optimized string length: " + optimized.length());

        // Scenario 3: Substring memory leak (pre-Java 7)
        System.out.println("\nScenario 3: Substring memory leak (historical)");
        System.out.println("- Pre-Java 7: substring() shared char array");
        System.out.println("- Could retain reference to large original string");
        System.out.println("- Java 7+: substring() creates new char array");
    }

    // ENTERPRISE PATTERNS AND BEST PRACTICES
    public static void enterprisePatterns() {
        System.out.println("\n=== ENTERPRISE PATTERNS ===");

        // Pattern 1: String Template Builder
        StringBuilder template = new StringBuilder();
        template.append("SELECT * FROM users WHERE ");
        template.append("status = ? AND ");
        template.append("created_date > ? AND ");
        template.append("department = ?");
        System.out.println("SQL Template: " + template);

        // Pattern 2: Fluent Interface for StringBuilder
        FluentStringBuilder fsb = new FluentStringBuilder()
                .append("Hello")
                .space()
                .append("World")
                .exclamation()
                .newLine()
                .append("Java Programming");
        System.out.println("Fluent result: " + fsb.toString());

        // Pattern 3: StringBuilder Pool for high-frequency operations
        System.out.println("\nPattern 3: StringBuilder Pool");
        System.out.println("- Reuse StringBuilder instances");
        System.out.println("- Reset length to 0 instead of creating new");
        System.out.println("- Useful for high-frequency string operations");

        StringBuilder pooled = new StringBuilder(1000);
        // Use StringBuilder
        pooled.append("Some content");
        String result = pooled.toString();
        // Reset for reuse
        pooled.setLength(0);
        System.out.println("Pooled StringBuilder ready for reuse");
    }

    // Custom Fluent StringBuilder for demonstration
    static class FluentStringBuilder {
        private StringBuilder sb = new StringBuilder();

        public FluentStringBuilder append(String str) {
            sb.append(str);
            return this;
        }

        public FluentStringBuilder space() {
            sb.append(" ");
            return this;
        }

        public FluentStringBuilder newLine() {
            sb.append("\n");
            return this;
        }

        public FluentStringBuilder exclamation() {
            sb.append("!");
            return this;
        }

        @Override
        public String toString() {
            return sb.toString();
        }
    }

    // EDGE CASES AND GOTCHAS
    public static void edgeCasesAndGotchas() {
        System.out.println("\n=== EDGE CASES AND GOTCHAS ===");

        // Gotcha 1: String concatenation with null
        String nullString = null;
        String result1 = "Hello" + nullString; // "Hellonull"
        System.out.println("Concatenation with null: " + result1);

        StringBuilder sb = new StringBuilder("Hello");
        sb.append(nullString); // "Hellonull"
        System.out.println("StringBuilder with null: " + sb);

        // Gotcha 2: Empty string vs null
        String empty = "";
        String nullStr = null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(empty); // No change
        sb2.append(nullStr); // Appends "null"
        System.out.println("Empty vs null: '" + sb2 + "'");

        // Gotcha 3: StringBuilder sharing references
        StringBuilder original = new StringBuilder("Original");
        StringBuilder shared = original; // Same reference!
        shared.append(" Modified");
        System.out.println("Original after modification: " + original);
        System.out.println("Shared reference issue demonstrated");

        // Gotcha 4: toString() returns new String each time
        StringBuilder sb3 = new StringBuilder("Test");
        String str1 = sb3.toString();
        String str2 = sb3.toString();
        System.out.println("toString() creates new objects: " + (str1 == str2)); // false

        // Gotcha 5: Capacity vs length confusion
        StringBuilder sb4 = new StringBuilder(100);
        System.out.println("Initial capacity: " + sb4.capacity());
        System.out.println("Initial length: " + sb4.length()); // 0, not 100!
    }

    public static void main(String[] args) {
        stringPoolInternals();
        stringBuilderOptimization();
        threadSafetyAnalysis();
        performanceBenchmark();
        advancedManipulation();
        memoryLeakScenarios();
        enterprisePatterns();
        edgeCasesAndGotchas();
    }
}