import type express from "express";

export abstract class CommonRoutesConfig {
  constructor(readonly app: express.Application, readonly name: string) {
    this.app = app;
    this.name = name;
    this.configureRoutes();
  }

  getName(): string {
    return this.name;
  }

  abstract configureRoutes(): express.Application;
}
