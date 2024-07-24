package modelos;

import java.util.*;

public record InformacionClimaOpenWee(String name,
                                      Map<String, String> main,
                                      double temp,
                                      double temp_min,
                                      double temp_max,
                                      List<Map<String,String>> weather) {
}
