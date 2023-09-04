import { UserI } from "src/app/interfaces/user-i"

export class User implements UserI {
    public fname: string;
    public lname: string;
    public email: string;
    public userId: string;
    public password?: string;

    constructor(fname: string, lname: string, email: string, userId: string, password: string) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.userId = userId;
        // TODO: store securely hased and salted 
        this.password = password;
    }


    public getName(defaultVal: string = ""): string {
        if (this.fname != undefined && this.lname != undefined)
            return `${this.fname} ${this.lname}`;
        else
            return defaultVal;
    }
}

