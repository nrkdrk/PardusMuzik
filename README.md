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

# handleNewTrackList
Kullanıcı 'Yeni Liste Oluştur'a tıklattığında çağrılır. Düzenlemek için bir iletişim kutusu açar.
```java
@FXML
    private void handleNewTrackList() {
        TrackList tempTrackList = new TrackList();
        boolean okClicked = mainApp.showTrackListDialog(tempTrackList);
        if (okClicked) {
            TrackListUtil.saveTrackList(tempTrackList);
            observableTrackListsView.add(tempTrackList);
        }
    }
```

# showTrackListDetails 
Parça listesini parça listesinde göster
```java
private void showTrackListDetails(TrackList trackList) {
        Platform.runLater(() -> {
            observableTracksView = TrackUtil.getAll(trackList, trackTableView);
            trackTableView.setItems(observableTracksView);
        });
        
        Platform.runLater(() -> {
            TrackUtil.refreshTable(trackTableView);
        });
    }
```
