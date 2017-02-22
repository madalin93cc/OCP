package ocp.nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * Created by Madalin.Colezea on 2/22/2017.
 * Flow;
 *  - create new WatchService
 *  - register it on a Path listening to one or more event types
 *  - loop until you are no longer intersted in these events
 *  - call key.pullEvents and do something with the event
 *  - call key.reset to look for more events
 *
 *  Rename = create file + delete file
 */
public class WatchServiceExamples {
    public static void main(String[] args) throws IOException{
        Path path = Paths.get("deldir");
        Path path1 = Paths.get("dir2");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, ENTRY_DELETE, ENTRY_CREATE, ENTRY_MODIFY);
        path1.register(watchService, ENTRY_CREATE);

        while (true) {
            WatchKey watchKey;
            try {
                watchKey = watchService.take();
//                watchKey = watchService.poll(60, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                return;
            }
            for (WatchEvent event: watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                System.out.println(kind.name());
                System.out.println(kind.type());
                System.out.println(event.count());
                System.out.println(event.context().toString());
            }
            watchKey.reset();
        }
    }
}
