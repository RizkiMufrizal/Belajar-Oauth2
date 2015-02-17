# Belajar-Oauth2

Resource Server         : `http://localhost:8001`

Authorization Server    : `http://localhost:8002`

Implicit Client         : `http://localhost:8000`

Cara Menjalankan        : `gradle clean build bootRun`

### Flow Grant Type Authorization Code

* jalankan `redis server`
* jalankan `Resource Server` dan `Authorization Server`
* isi username dan password (password yang sudah di hast oleh algoritma Bcrypt) dalam database dengan Role : ROLE_ADMIN
* lalu hit ke browser :

    `localhost:8002/oauth/authorize?client_id=clientauthcode&response_type=code&redirect_uri=http://localhost:8001/api/state/new`

* maka kita akan redirect ke halaman page login, login sesuai dengan user dan password yang anda buat
* muncul halaman OAuth Approval, lalu pilih approve klik authorize maka akan menghasilkan url berikut :

    `http://localhost:8001/api/state/new?code=YMH5ao`

* ambil kode terakhir yaitu `YMH5ao`
* kemudian lakukan request token ke server, disini kita menggunakan aplikasi command line yaitu `curl` jalankan perintah berikut :

    `curl -X POST -vu clientauthcode:123456 http://localhost:8002/oauth/token -H "Accept: application/json" -d "grant_type=authorization_code&code=YMH5ao&redirect_uri=http://localhost:8001/api/state/new"`

* jangan lupa untuk memasukkan kode authorization yang anda dapatkan ke url tadi, kode tersebut berada di `authorization_code&code=YMH5ao`
* maka akan tampil response seperti berikut :

    ```json
    {
        "access_token":"d41b8531-1e8e-452e-936d-c214778ff178",
        "token_type":"bearer",
        "refresh_token":"6281a71d-6c6a-4ceb-941e-f6f673b87e6c",
        "expires_in":43199,
        "scope":"read write"
    }
    ```
* lalu kita melakukan request terhadapat resource yang terproteksi dengan menggunakan token tersebut :

    `http://localhost:8001/api/admin?access_token=d41b8531-1e8e-452e-936d-c214778ff178`

* maka akan menhasilkan response berikut :

    ```json
    {
        "User":"admin@gmail.com",
        "Success":true
    }
    ```

* bila token expire maka kita lakukan refresh token yaitu :

    `curl -X POST -vu clientauthcode:123456 http://localhost:8002/oauth/token -d "client_id=clientauthcode&grant_type=refresh_token&refresh_token=6281a71d-6c6a-4ceb-941e-f6f673b87e6c"`

* isi token tersebut dengan refresh token, kemudian server akan memberikan respone token dan refresh token terbaru :

    ```json
    {
        "access_token":"02c37d6c-6cbb-4fb9-9564-4c5c9966f537",
        "token_type":"bearer",
        "refresh_token":"6281a71d-6c6a-4ceb-941e-f6f673b87e6c",
        "expires_in":43199,
        "scope":"read write"
    }
    ```

### Flow Grant Type Implicit

* jalankan `redis server`
* jalankan `Resource Server`, `Authorization Server` dan `Implicit Client`
* lalu buka browser di `http://localhost:8000/index`
* jika token masih belum terdapat di session storage dan di url maka akan redirect ke login page
* jika berhasil login maka kita akan redirect ke page home
* token ini hanya berlaku sehari

### Referensi

Server Side :
* https://github.com/endymuhardin/belajar-springoauth2
* https://github.com/spring-projects/spring-security-oauth/tree/master/samples
* https://github.com/royclarkson/spring-rest-service-oauth
* http://www.beingjavaguys.com/2014/10/spring-security-oauth2-integration.html
* https://github.com/RizkiMufrizal/Belajar-Cache-Dengan-Redis

Angular :
* https://github.com/angular-ui/ui-router/wiki
* https://github.com/angular-ui/ui-router/wiki/Frequently-Asked-Questions
* https://github.com/RizkiMufrizal/Belajar-Testing-Aplikasi/tree/master/Belajar-Testing-Angular/src/main/webapp
* http://www.frederiknakstad.com/2014/02/09/ui-router-in-angular-client-side-auth/

Grunt :
* http://gruntjs.com/sample-gruntfile
* https://github.com/stephenplusplus/grunt-wiredep
* http://stephenplusplus.github.io/grunt-wiredep/

Gradle :
* http://gradle.org/docs/2.2/userguide/userguide_single.html#multi_project_builds
* http://gradle.1045684.n5.nabble.com/Provided-dependencies-td3327063.html (Fixing Provided Dependency)