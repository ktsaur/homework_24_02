package Transport.model;

//найти все автобусы опред маршрута

//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.File;
//import java.io.IOException;
//
//public class MainTransport {
//    public static void main(String[] args) {
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            TransportDataBase dataBase =
//                    mapper.readValue(new File("transport.json"), TransportDataBase.class);
//
//            if (dataBase != null) {
//                dataBase.getData().getVehicles().stream().filter(v -> v.getProperties().getVehicleMetaData().getTransport().getType().equals("bus"));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}


import com.fasterxml.jackson.databind.ObjectMapper;
//import inf17_02.List;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainTransport {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            TransportDataBase dataBase =
                    mapper.readValue(new File("transport.json"), TransportDataBase.class);

            if (dataBase != null) {
                //1
                Set<String> types = dataBase.getData().getVehicles().stream().map(v -> v.getProperties().getVehicleMetaData().getTransport().getType()).collect(Collectors.toSet());System.out.println(types);

                //2
                String nomer = "55";
                String type = "bus";
                System.out.println(dataBase.getData().getVehicles().stream().filter(v -> (v.getProperties().getVehicleMetaData().getTransport().getName().equals(nomer))
                        & (v.getProperties().getVehicleMetaData().getTransport().getType().equals(type))).count());


                //3
                Map<String, Integer> map = dataBase.getData().getVehicles().stream()
                        .collect(Collectors.toMap(v -> v.getProperties().getVehicleMetaData().getTransport().getName(),
                                v -> v.getFeatures().stream().mapToInt(e -> e.getGeometry().getCoordinates().size()).sum(),
                                (v1, v2) -> v1));

                System.out.println();
                for(String keys: map.keySet()){
                    System.out.println(keys +  ", " + map.get(keys));
                }


                //4
                dataBase.getData().getVehicles().stream()
                        .map(v -> List.of(v.getProperties().getVehicleMetaData().getTransport().getName(),
                                v.getProperties().getVehicleMetaData().getTransport().getType(),
                                v.getProperties().getVehicleMetaData().getTransport().getId()))
                        .toList().stream().sorted(Comparator.comparing(e->e.get(0))).forEach(System.out::println);


                //5
                Map<String, long[]> z5 = dataBase.getData().getVehicles().stream()
                        .collect(Collectors.toMap(v -> v.getProperties().getVehicleMetaData().getTransport().getName(), v -> v.getFeatures().stream().mapToLong(x -> {
                            return (x.getProperties().getTrajectorySegmentMetaData().getTime());
                        }).toArray(), (v1, v2) -> v1));

                System.out.println();
                for(String keys: z5.keySet()){
                    System.out.println(keys +  ", " + Arrays.toString(z5.get(keys)));
                }


                //6
                String tr = "tramway";
                String bus = "bus";
                String trolleybus = "trolleybus";

                dataBase.getData().getVehicles().stream().
                        filter(v ->
                            v.getProperties().getVehicleMetaData().getTransport().getType().equals(tr)
                            || v.getProperties().getVehicleMetaData().getTransport().getType().equals(bus)
                            || v.getProperties().getVehicleMetaData().getTransport().getType().equals(trolleybus)).forEach(x -> System.out.println(x.getProperties().getVehicleMetaData().getTransport().getId()));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}