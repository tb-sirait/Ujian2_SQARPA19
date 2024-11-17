package atm_product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {
    private atm atm;

    @BeforeMethod
    public void setUp() {
        // Inisialisasi objek ATM dengan saldo awal sebesar 1000
        atm = new atm(1000);
    }

    @Test
    public void testLihatSaldo() {
        // Menguji apakah metode lihatSaldo() mengembalikan saldo yang benar
        Assert.assertEquals(atm.lihatSaldo(), 1000.0, "Saldo harus 1000");
    }

    @Test
    public void testSetorUang() {
        // Menguji apakah metode setorUang() berfungsi dengan benar ketika jumlah yang valid disetor
        atm.setorUang(500);
        Assert.assertEquals(atm.lihatSaldo(), 1500.0, "Saldo harus 1500 setelah setor 500");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, 
          expectedExceptionsMessageRegExp = "Jumlah harus lebih besar dari 0 ")
    public void testSetorUangNegatif() {
        // Menguji apakah metode setorUang() melempar pengecualian ketika jumlah yang negatif disetor
        atm.setorUang(0);
    }

    @Test
    public void testTarikUang() {
        // Menguji apakah metode tarikUang() berfungsi dengan benar ketika jumlah yang valid ditarik
        atm.tarikUang(300);
        Assert.assertEquals(atm.lihatSaldo(), 700.0, "Saldo harus 700 setelah tarik 300");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, 
          expectedExceptionsMessageRegExp = "Saldo tidak mencukupi ")
    public void testTarikUangLebihDariSaldo() {
        // Menguji apakah metode tarikUang() melempar pengecualian ketika jumlah yang ditarik melebihi saldo saat ini
        atm.tarikUang(1200);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, 
          expectedExceptionsMessageRegExp = "Jumlah harus lebih besar dari 0 ")
    public void testTarikUangNegatif() {
        // Menguji apakah metode tarikUang() melempar pengecualian ketika jumlah yang negatif ditarik
        atm.tarikUang(-200);
    }
}