export class NewUser {
    nameUser: string;
    login: string;
    email: string;
    roles: string[];
    password: string;

    constructor(nameUser: string, login: string, email: string, password: string) {
        this.nameUser = nameUser;
        this.login = login;
        this.email = email;
        this.password = password;
        this.roles = ['user'];
    }
}