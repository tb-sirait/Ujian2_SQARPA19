package atm_product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {
    private atm atm;

    @BeforeMethod
    public void setUp() {
        atm = new atm(1000);
    }

    @Test
    public void testLihatSaldo() {
        Assert.assertEquals(atm.lihatSaldo(), 1000.0, "Saldo harus 1000");
    }

    @Test
    public void testSetorUang() { 
        atm.setorUang(500);
        Assert.assertEquals(atm.lihatSaldo(), 1500.0, "Saldo harus 1500 setelah setor 500");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, 
          expectedExceptionsMessageRegExp = "Jumlah harus lebih besar dari 0 ")
    public void testSetorUangNegatif() {
        atm.setorUang(0);
    }

    @Test
    public void testTarikUang() {
        atm.tarikUang(300);
        Assert.assertEquals(atm.lihatSaldo(), 700.0, "Saldo harus 700 setelah tarik 300");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, 
          expectedExceptionsMessageRegExp = "Saldo tidak mencukupi ")
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(1200);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, 
          expectedExceptionsMessageRegExp = "Jumlah harus lebih besar dari 0 ")
    public void testTarikUangNegatif() {
        atm.tarikUang(-200);
    }
}