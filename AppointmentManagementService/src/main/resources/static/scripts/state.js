class State {
    static set LiveID(id) {
        sessionStorage.setItem('user-id', id);
    }

    static get LiveID() {
        if (sessionStorage.getItem('user-id')) {
            return Number.parseInt(sessionStorage.getItem('user-id'));
        }
        return -1;
    }
    static set LiveFirst(first){

    }
}
