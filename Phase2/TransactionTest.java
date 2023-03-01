import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    @Test
    @DisplayName("Test create code conversion")
    void testCreateCodeConversion(){
        assertEquals("01", Transaction.transactionTypeToCode(TransactionType.CREATE));
    }

    // Delete
    @Test
    @DisplayName("Test delete code conversion")
    void testDeleteCodeConversion(){
        assertEquals("02", Transaction.transactionTypeToCode(TransactionType.DELETE));
    }

    // Search
    @Test
    @DisplayName("Test search code conversion")
    void testSearchCodeConversion(){
        assertEquals("04", Transaction.transactionTypeToCode(TransactionType.SEARCH));
    }

    // Post
    @Test
    @DisplayName("Test post code conversion")
    void testPostCodeConversion(){
        assertEquals("03", Transaction.transactionTypeToCode(TransactionType.POST));
    }

    // Rent
    @Test
    @DisplayName("Test rent code conversion")
    void testRentCodeConversion(){
        assertEquals("05", Transaction.transactionTypeToCode(TransactionType.RENT));
    }

    // Logout
    @Test
    @DisplayName("Test logout code conversion")
    void testLogoutCodeConversion(){
        assertEquals("00", Transaction.transactionTypeToCode(TransactionType.LOGOUT));
    }

    // @Test
    // @DisplayName("Test code string initialisation")
    // void testCodeStringInitialised() {
    //     assertEquals("01", Transaction.transactionTypeToCode(TransactionType.CREATE));
    // }

    // @Test
    // @DisplayName("Test switch loop begun")
    // void testSwitchLoopReached() {
    //     assertEquals("01", Transaction.transactionTypeToCode(TransactionType.CREATE));
    // }

    // @Test
    // @DisplayName("Test code conversion create case reached")
    // void testCodeConversionCreateCase() {
    //     assertEquals("01", Transaction.transactionTypeToCode(TransactionType.CREATE));
    // }

    // @Test
    // @DisplayName("Test code conversion create code is set")
    // void testCodeConversionCreateCodeSet() {
    //     assertEquals("01", Transaction.transactionTypeToCode(TransactionType.CREATE));
    // }

    // @Test
    // @DisplayName("Test code conversion create case break reached")
    // void testCodeConversionCreateCaseBreak() {
    //     assertEquals("01", Transaction.transactionTypeToCode(TransactionType.CREATE));
    // }


    // @Test
    // @DisplayName("Test code conversion delete case reached")
    // void testCodeConversionDeleteCase() {
    //     assertEquals("02", Transaction.transactionTypeToCode(TransactionType.DELETE));
    // }

    // @Test
    // @DisplayName("Test code conversion delete code is set")
    // void testCodeConversionDeleteCodeSet() {
    //     assertEquals("02", Transaction.transactionTypeToCode(TransactionType.DELETE));
    // }

    // @Test
    // @DisplayName("Test code conversion delete case break reached")
    // void testCodeConversionDeleteCaseBreak() {
    //     assertEquals("02", Transaction.transactionTypeToCode(TransactionType.DELETE));
    // }

    // @Test
    // @DisplayName("Test code conversion search case reached")
    // void testCodeConversionSearchCase() {
    //     assertEquals("04", Transaction.transactionTypeToCode(TransactionType.SEARCH));
    // }

    // @Test
    // @DisplayName("Test code conversion search code is set")
    // void testCodeConversionSearchCodeSet() {
    //     assertEquals("04", Transaction.transactionTypeToCode(TransactionType.SEARCH));
    // }

    // @Test
    // @DisplayName("Test code conversion search case break reached")
    // void testCodeConversionSearchCaseBreak() {
    //     assertEquals("04", Transaction.transactionTypeToCode(TransactionType.SEARCH));
    // }

    // @Test
    // @DisplayName("Test code conversion post case reached")
    // void testCodeConversionPostCase() {
    //     assertEquals("03", Transaction.transactionTypeToCode(TransactionType.POST));
    // }

    // @Test
    // @DisplayName("Test code conversion post code is set")
    // void testCodeConversionPostCodeSet() {
    //     assertEquals("03", Transaction.transactionTypeToCode(TransactionType.POST));
    // }

    // @Test
    // @DisplayName("Test code conversion post case break reached")
    // void testCodeConversionPostCaseBreak() {
    //     assertEquals("03", Transaction.transactionTypeToCode(TransactionType.POST));
    // }

    // @Test
    // @DisplayName("Test code conversion rent case reached")
    // void testCodeConversionRentCase() {
    //     assertEquals("05", Transaction.transactionTypeToCode(TransactionType.RENT));
    // }

    // @Test
    // @DisplayName("Test code conversion rent code is set")
    // void testCodeConversionRentCodeSet() {
    //     assertEquals("05", Transaction.transactionTypeToCode(TransactionType.RENT));
    // }

    // @Test
    // @DisplayName("Test code conversion rent case break reached")
    // void testCodeConversionRentCaseBreak() {
    //     assertEquals("05", Transaction.transactionTypeToCode(TransactionType.RENT));
    // }

    // @Test
    // @DisplayName("Test code conversion logout case reached")
    // void testCodeConversionLogoutCase() {
    //     assertEquals("00", Transaction.transactionTypeToCode(TransactionType.LOGOUT));
    // }

    // @Test
    // @DisplayName("Test code conversion logout code is set")
    // void testCodeConversionLogoutCodeSet() {
    //     assertEquals("00", Transaction.transactionTypeToCode(TransactionType.LOGOUT));
    // }

    // @Test
    // @DisplayName("Test code conversion logout case break reached")
    // void testCodeConversionLogoutCaseBreak() {
    //     assertEquals("00", Transaction.transactionTypeToCode(TransactionType.LOGOUT));
    // }
}
