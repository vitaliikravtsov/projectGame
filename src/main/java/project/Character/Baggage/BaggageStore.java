package project.Character.Baggage;

import lombok.extern.java.Log;
import org.springframework.boot.logging.LoggerGroup;
import project.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.reflect.Field;


public class BaggageStore {
    public ArrayList<BaggageItem> baggageItems= new ArrayList<>();

    public BaggageItem createBaggageItem(String type, int additionalHealth, int additionalAttackPower, int additionalProtection) {
        BaggageItem baggageItem = new BaggageItem(type, additionalHealth, additionalAttackPower, additionalProtection);
        baggageItems.add(baggageItem);
        return baggageItem;
    }

    public ArrayList<BaggageItem> getBaggageStore() {
        return baggageItems;
    }

    @Override
    public String toString() {
        return "BaggageStore{" +
                "baggageItems=" + baggageItems +
                '}';
    }
}