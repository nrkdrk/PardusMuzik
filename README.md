# PardusMuzik
![N|Solid](https://github.com/nrkdrk/PardusMuzik/blob/master/img/nrkdrk.jpg)


# Pardus Müzik Logosu
![alt text](https://github.com/nrkdrk/PardusMuzik/blob/master/img/icon.png)

# PardusMuzik
Karşılama Sayfası
![alt text](https://github.com/nrkdrk/PardusMuzik/blob/master/img/PardusMuzik.PNG)


# Pardus Müzik Özellikleri
| Pardus Müzik | |
| ------ | ------ |
| Müzik(Parça) Detay | |
| Çalma Listesi Oluşturma | |
| Çalma Listesi Silme | |
| Otomatik İlerleme| |

# Model
  # Track Model

  ```java
      private StringProperty fileName;
      private StringProperty path;
      private Media media;
      private StringProperty album;
      private StringProperty artist;
      private StringProperty title;
      private StringProperty year;
      private Image image;

      public Track() {
          this(null, null, null);
      }

      public Track(String fileName, String filePath, Media media) {
          this.fileName = new SimpleStringProperty(fileName);
          this.path = new SimpleStringProperty(filePath);
          this.media = media;
      }
  ```

  # TrackList Model

  ```java
      private IntegerProperty id;
      private StringProperty name;
      private StringProperty path;

      public TrackList() {
          this(0, null, null);
      }

       public TrackList(Integer id, String name, String path) {
          this.id = new SimpleIntegerProperty(id);
          this.name = new SimpleStringProperty(name);
          this.path = new SimpleStringProperty(path);
      }
  ```

