package com.github.mrgalek;

import com.github.mrgalek.controllers.BankController;

public class Main {

    public static void main(String[] args)
    {
	BankController bankController = new BankController();
	bankController.startApp();
    }
}
