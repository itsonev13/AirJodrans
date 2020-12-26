function nextbtn() {
    let url = window.location.href;
    if (url.slice(-1) == 's') {
        window.location.replace("/shoesP2");
    } else {
        let pageArr = /P\d+/.exec(url);
        let page = pageArr[0];
        page = page.substring(1);
        page++;
        window.location.replace(`/shoesP${page}`)
    }
}