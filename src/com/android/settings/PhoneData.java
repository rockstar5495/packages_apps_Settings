package com.android.settings;

import java.util.ArrayList;
import java.util.List;
import com.android.settings.R;

public final class PhoneData {
	public static List<AboutPhoneData> data = new ArrayList<>();
	static {
	data.add(new AboutPhoneData(0));

	// Raphael
        data.add(new AboutPhoneData(1,
                "raphael",
                "1 x 2.84 + 3 x 2.42 GHz + 4 x 1.78",
                "Snapdragon 855 (7 nm)",
                "4000",
                "1080 x 2340, 6.39 inches",
                "48MP + 8MP + 13MP, 20MP"
        ));
        // Raphaelin
        data.add(new AboutPhoneData(2,
                "raphaelin",
                "1 x 2.84 + 3 x 2.42 GHz + 4 x 1.78",
                "Snapdragon 855 (7 nm)",
                "4000",
                "1080 x 2340, 6.39 inches",
                "48MP + 8MP + 13MP, 20MP"
        ));
        // Mido
        data.add(new AboutPhoneData(3,
                "mido",
                "8 x 2.0Ghz",
                "Snapdragon 625 (14 nm)",
                "4000",
                "1080 x 1920, 5.5 inches",
                "13MP, 5MP"
        ));
        // lemonkebab
        data.add(new AboutPhoneData(4,
                "lemonkebab",
                "1 x 3.2 + 3 x 2.42 + 4 x 1.80",
                "Snapdragon SM8250",
                "4500",
                "1080 x 2400, 6.55 inches",
                "48MP + 16MP + 5MP + 2MP, 16MP"
        ));
        //tucana
        data.add(new AboutPhoneData(5,
                "tucana",
                "2 x 2.2 GHz, 6 x 1.8 GHz",
                "Snapdragon 730G",
                "5260",
                "1080 x 2340, 6.47 inches",
                "108MP+12MP+8MP+20MP+2MP, 32MP"
        ));
        // Mojito
        data.add(new AboutPhoneData(6,
                "mojito",
                "2 x 2.28 GHz + 6 x 1.78 GHz",
                "Snapdragon 678 (11 nm)",
                "5000",
                "1080 x 2400, 6.43 inches",
                "48MP + 8MP + 2MP + 2MP, 13MP"
        ));
        // sweetin
        data.add(new AboutPhoneData(7,
                "sweetin",
                "2 x 2.3Ghz, 6 x 1.8Ghz",
                "Snapdragon 732G (8 nm)",
                "5020",
                "1080 x 2400, 6.67 inches",
                "64MP+8MP+5MP+2MP, 16MP"
        ));
        // sweetinpro
        data.add(new AboutPhoneData(8,
                "sweetinpro",
                "2 x 2.3Ghz, 6 x 1.8Ghz",
                "Snapdragon 732G (8 nm)",
                "5020",
                "1080 x 2400, 6.67 inches",
                "108MP+8MP+5MP+2MP, 16MP"
        ));
        // sweet
        data.add(new AboutPhoneData(9,
                "sweet",
                "2 x 2.3Ghz, 6 x 1.8Ghz",
                "Snapdragon 732G (8 nm)",
                "5020",
                "1080 x 2400, 6.67 inches",
                "108MP+8MP+5MP+2MP, 16MP"
        ));
        // Lavender
        data.add(new AboutPhoneData(10,
                "lavender",
                "4 x 2.2 GHz + 4 x 1.8 GHz",
                "Snapdragon 660 (14 nm)",
                "4000",
                "1080 x 2340, 6.3 inches",
                "48MP + 5MP , 13MP"
        ));
        // Vince
        data.add(new AboutPhoneData(11,
                "vince",
                "8 × 2.0 GHz",
                "Snapdragon 625 (14 nm)",
                "4000",
                "1080 x 2160, 5.99 inches",
                "12 MP, 5MP"
        ));
        // Santoni
        data.add(new AboutPhoneData(12,
                "santoni",
                "8 x 1.4Ghz",
                "Snapdragon 435 (28 nm)",
                "4000",
                "720 x 1280, 5.0 inches",
                "13MP, 5MP"
        ));
        // Excalibur
        data.add(new AboutPhoneData(13,
                "excalibur",
                "2x2.3GHz + 6x1.8GHz",
                "Snapdragon 720G (8 nm)",
                "5020",
                "1080 x 2400, 6.67 inches",
                "64MP + 8MP + 5MP + 2MP, 32MP"
        ));
        // Curtana
        data.add(new AboutPhoneData(14,
                "curtana",
                "2x2.3GHz + 6x1.8GHz",
                "Snapdragon 720G (8 nm)",
                "5020",
                "1080 x 2400, 6.67 inches",
                "48MP + 8MP + 5MP + 2MP, 16MP"
        ));
        // Joyeuse
        data.add(new AboutPhoneData(15,
                "joyuse",
                "2x2.3GHz + 6x1.8GHz",
                "Snapdragon 720G (8 nm)",
                "5020",
                "1080 x 2400, 6.67 inches",
                "64MP + 8MP + 5MP + 2MP, 16MP"
        ));
        // Gram
        data.add(new AboutPhoneData(16,
                "gram",
                "2x2.3GHz + 6x1.8GHz",
                "Snapdragon 720G (8 nm)",
                "5020",
                "1080 x 2400, 6.67 inches",
                "48MP + 8MP + 5MP + 2MP, 16MP"
        ));
        // Alioth/IN
        data.add(new AboutPhoneData(17,
                "alioth",
                "1 x 3.2 GHz, 3 x 2.42 GHz, 4 x 1.80 GHz",
                "Snapdragon 870",
                "4520",
                "1080 x 2400, 6.67 inches",
                "48MP + 8MP + 5MP, 20MP"
        ));
        data.add(new AboutPhoneData(18,
                "aliothin",
                "1 x 3.2 GHz, 3 x 2.42 GHz, 4 x 1.80 GHz",
                "Snapdragon 870",
                "4520",
                "1080 x 2400, 6.67 inches",
                "48MP + 8MP + 5MP, 20MP"
        ));
        // X2
        data.add(new AboutPhoneData(19,
                "X2",
                "2 x 2.2 + 6 x 1.8 GHz",
                "Snapdragon 730g",
                "4000",
                "1080 x 2340, 6.4 inches",
                "64MP + 8MP + 2MP + 2MP, 32MP"
        ));
        // RMX2061
        data.add(new AboutPhoneData(20,
                "RMX2061",
                "2x2.3 GHz Kryo 465 Gold & 6x1.8 GHz Kryo 465 Silver",
                "Snapdragon 720G (12 nm)",
                "4300",
                "1080 x 2400, 6.6 inches",
                "64MP+12MP+8MP+2MP, 16MP+8MP"
        ));
        // Realme 6
        data.add(new AboutPhoneData(21,
                "RMX2001",
                "6 x 2.0 GHz + 2 x 2.05 GHz",
                "Mediatek G90T (12 nm)",
                "4300",
                "1080 x 2400, 6.5 inches",
                "64MP+8MP+2MP+2MP,16MP"
        ));
        // Realme 6i (India)/6S
        data.add(new AboutPhoneData(22,
                "RMX2002",
                "6 x 2.0 GHz + 2 x 2.05 GHz",
                "Mediatek G90T (12 nm)",
                "4300",
                "1080 x 2400, 6.5 inches",
                "48MP+8MP+2MP+2MP,16MP"
        ));
        // Realme Narzo
        data.add(new AboutPhoneData(23,
                "RMX2003",
                "6 x 2.0 GHz + 2 x 2.05 GHz",
                "Mediatek G90T (12 nm)",
                "4300",
                "1080 x 2400, 6.5 inches",
                "48MP+8MP+2MP+2MP,16MP"
        ));
        // Realme 7
        data.add(new AboutPhoneData(24,
                "RMX2151",
                "6 x 2.0 GHz + 2 x 2.05 GHz",
                "Mediatek G95 (12 nm)",
                "5000",
                "1080 x 2400, 6.5 inches",
                "64MP+8MP+2MP+2MP,16MP"
        ));
        // Realme Narzo 20 Pro
        data.add(new AboutPhoneData(25,
                "RMX2161",
                "6 x 2.0 GHz + 2 x 2.05 GHz",
                "Mediatek G95 (12 nm)",
                "4500",
                "1080 x 2400, 6.5 inches",
                "48MP+8MP+2MP+2MP,16MP"
        ));
        // Realme Narzo 30 4G
        data.add(new AboutPhoneData(26,
                "RMX2156",
                "6 x 2.0 GHz + 2 x 2.05 GHz",
                "Mediatek G95 (12 nm)",
                "5000",
                "1080 x 2400, 6.5 inches",
                "48MP+8MP+2MP+2MP,16MP"
        ));
        // merlin
        data.add(new AboutPhoneData(27,
                "merlin",
                "2 x 2.0Ghz, 6 x 1.8Ghz",
                "Mediatek G85 (12 nm)",
                "5020",
                "1080 x 2340, 6.53 inches",
                "48MP+8MP+2MP+2MP, 13MP"
        ));
        // surya
        data.add(new AboutPhoneData(28,
                "surya",
                "2 x 2.3Ghz, 6 x 1.8Ghz",
                "Snapdragon 732G (8 nm)",
                "5160",
                "1080 x 2400, 6.67 inches",
                "64MP+13MP+2MP+2MP, 20MP"
        ));
        // karna
        data.add(new AboutPhoneData(29,
                "karna",
                "2 x 2.3Ghz, 6 x 1.8Ghz",
                "Snapdragon 732G (8 nm)",
                "6000",
                "1080 x 2400, 6.67 inches",
                "64MP+13MP+2MP+2MP, 20MP"
        ));
        // apollo
        data.add(new AboutPhoneData(30,
                "apollo",
                "1 x 2.84Ghz, 3 x 2.42Ghz, 4 x 1.8GHz",
                "Snapdragon 865 (7 nm)",
                "5000",
                "1080 x 2400, 6.67 inches",
                "64MP+13MP+5MP, 20MP"
        ));
        // apollopro
        data.add(new AboutPhoneData(31,
                "apollopro",
                "1 x 2.84Ghz, 3 x 2.42Ghz, 4 x 1.8GHz",
                "Snapdragon 865 (7 nm)",
                "5000",
                "1080 x 2400, 6.67 inches",
                "108MP+13MP+5MP, 20MP"
        ));
        // phoenixin
        data.add(new AboutPhoneData(32,
                "phoenixin",
                "2 x 2.2Ghz, 6 x 1.8Ghz",
                "Snapdragon 730G (8 nm)",
                "4500",
                "1080 x 2400, 6.67 inches",
                "64MP+8MP+2MP+2MP, 20MP"
        ));
        // phoenix
        data.add(new AboutPhoneData(33,
                "phoenix",
                "2 x 2.2Ghz, 6 x 1.8Ghz",
                "Snapdragon 730G (8 nm)",
                "45",
                "1080 x 2400, 6.67 inches",
                "64MP+8MP+2MP+2MP, 20MP"
        ));
        //whyred
        data.add(new AboutPhoneData(34,
                "whyred",
                "8 x 1.8GHz",
                "Snapdragon 636",
                "4000",
                "2160 x 1080, 5.9 inches",
                "12MP + 5MP + 20MP"
        ));
        //RMX1921
        data.add(new AboutPhoneData(35,
                "rmx1921",
                "8 x 2.30GHz",
                "Snapdragon 712",
                "4000",
                "1080 x 2340, 6.4 inches",
                "64MP + 8MP + 2MP + 2MP"
        ));
        //ysl
        data.add(new AboutPhoneData(36,
                "ysl",
                "8 x 2.0GHz",
                "Snapdragon 625",
                "3080",
                "1440 x 720, 5.99 inches",
                "12MP + 5MP, 16MP"
        ));
        //RMX1971
        data.add(new AboutPhoneData(37,
                "RMX1971",
                "2 x 2.3Ghz, 6 x 1.7Ghz",
                "Snapdragon 712",
                "4035",
                "2340 x 1080, 6.3 inches",
                "48MP + 8MP, 16MP"
        ));
        // Sunny
        data.add(new AboutPhoneData(38,
                "sunny",
                "2 x 2.28 GHz + 6 x 1.78 GHz",
                "Snapdragon 678 (11 nm)",
                "5000",
                "1080 x 2400, 6.43 inches",
                "48MP + 8MP + 2MP + 2MP, 13MP"
        ));
         //RMX2170 (Realme 7 Pro)
         data.add(new AboutPhoneData(39,
                "RMX2170",
                "2 x 2.3 GHz, 6 x 1.8 GHz",
                "Snapdragon 720G",
                "4500",
                "1080 x 2400, 6.44 inches",
                "64MP + 16MP + 2MP + 2MP, 32MP"
        ));
        //Z01R
        data.add(new AboutPhoneData(40,
               "Z01R",
               "4 x 2.7GHz, 4 x 1.7GHz",
               "Snapdragon 845",
               "3300",
               "1080 x 2246, 6.2 inches",
               "12MP + 8MP, 8MP"
      ));
      //Violet (Redmi Note 7 Pro)
      data.add(new AboutPhoneData(41,
              "violet",
              "2 x 2.0 + 6 x 1.7 GHz",
              "Snapdragon 675 (11 nm)",
              "4000",
              "1080 x 2340, 6.3 inches",
              "48MP + 5MP + 13MP"
      ));
}
    public static List<AboutPhoneData> getData() {
	return data;
    }
}
