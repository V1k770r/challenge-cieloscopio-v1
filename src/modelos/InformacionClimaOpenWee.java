package modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public record InformacionClimaOpenWee(String name,

                                      double temp,
                                      double temp_min,
                                      double temp_max,
                                      String description) {



}
