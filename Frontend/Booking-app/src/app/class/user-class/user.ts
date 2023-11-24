import { UserI } from "src/app/interfaces/user-i"

export class User implements UserI {
    public firstName: string;
    public lastName: string;
    public email: string;
    public username: string;
    public password?: string;

    constructor(fname: string = "", lname: string = "", email: string = "", userId: string = "", password: string = "") {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
        this.username = userId;
        this.password = password;
    }

    public getName(defaultVal: string = ""): string {
        if (this.firstName != undefined && this.lastName != undefined)
            return `${this.firstName} ${this.lastName}`;
        else
            return defaultVal;
    }
}

