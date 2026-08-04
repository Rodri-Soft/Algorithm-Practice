package PalindromicSubstring;

public class PalindromicSubstringOptimized {
    public static void main(String[] args) {
        PalindromicSubstringOptimized ps = new PalindromicSubstringOptimized();

        String test1 = "babad";
        String test2 = "cbbd";
        String test3 = "a";
        String test4 = "ac";

        System.out.println("--- Expand Around Center ---");
        System.out.println("Result for 'babad': " + ps.longestPalindromeExpandCenter(test1));
        System.out.println("Result for 'cbbd':  " + ps.longestPalindromeExpandCenter(test2));
        System.out.println("Result for 'a':     " + ps.longestPalindromeExpandCenter(test3));
        System.out.println("Result for 'ac':    " + ps.longestPalindromeExpandCenter(test4));

        System.out.println("\n--- Manacher's Algorithm O(N) ---");
        System.out.println("Result for 'babad': " + ps.longestPalindromeManacher(test1));
        System.out.println("Result for 'cbbd':  " + ps.longestPalindromeManacher(test2));
        System.out.println("Result for 'a':     " + ps.longestPalindromeManacher(test3));
        System.out.println("Result for 'ac':    " + ps.longestPalindromeManacher(test4));
    }

    /**
     * Enfoque 1: Expand Around Center (Expandir desde el centro)
     * Complejidad de Tiempo: O(N^2)
     * Complejidad de Espacio: O(1)
     */
    public String longestPalindromeExpandCenter(String s) {
        if (s == null || s.length() < 1) return "";

        char[] chars = s.toCharArray();
        int start = 0, maxLen = 0;

        for (int i = 0; i < chars.length; i++) {
            // Poda: Si la longitud restante no puede superar el máximo actual, salir
            if (chars.length - i <= maxLen / 2) break;

            int left = i, right = i;

            // Agrupar caracteres duplicados iguales contiguos (ej. "aaaa")
            while (right < chars.length - 1 && chars[right] == chars[right + 1]) {
                right++;
            }
            i = right; // Avanzamos el puntero del bucle principal

            // Expandir a la izquierda y derecha mientras sigan siendo iguales
            while (left > 0 && right < chars.length - 1 && chars[left - 1] == chars[right + 1]) {
                left--;
                right++;
            }

            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
                start = left;
            }
        }

        return new String(chars, start, maxLen);
    }

    /**
     * Enfoque 2: Algoritmo de Manacher
     * Complejidad de Tiempo: O(N) lineal
     * Complejidad de Espacio: O(N)
     */
    public String longestPalindromeManacher(String s) {
        if (s == null || s.length() == 0) return "";

        // Transformar la cadena s -> "^#a#b#a#b#a#$" para manejar longitudes pares e impares uniformemente
        StringBuilder sb = new StringBuilder();
        sb.append('^'); // Delimitador de inicio para evitar salir de límites
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#$"); // Delimitador de fin
        char[] t = sb.toString().toCharArray();

        int n = t.length;
        int[] p = new int[n]; // Radio del palíndromo centrado en i
        int center = 0, rightBoundary = 0;

        int maxLen = 0;
        int centerIndex = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i; // Índice espejo de i respecto al centro actual

            // Aprovechar la simetría si estamos dentro del límite derecho
            if (rightBoundary > i) {
                p[i] = Math.min(rightBoundary - i, p[mirror]);
            }

            // Intentar expandir alrededor de i
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
                p[i]++;
            }

            // Si el palíndromo centrado en i supera el límite derecho actual, actualizar centro y límite
            if (i + p[i] > rightBoundary) {
                center = i;
                rightBoundary = i + p[i];
            }

            // Guardar el palíndromo más largo
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
