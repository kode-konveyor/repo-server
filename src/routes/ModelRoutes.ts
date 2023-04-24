/* eslint-disable @typescript-eslint/no-misused-promises */
import { CommonRoutesConfig } from "./CommonRoutesConfig.js";
import { bound } from "cdd-ts";
import type express from "express";
import { GetElementControllerService } from "../services/GetElementControllerService.js";
import { SaveElementControllerService } from "../services/SaveElementControllerService.js";

const MODEL = "model";

export class UsersRoutes extends CommonRoutesConfig {
  constructor(app: express.Application) {
    super(app, MODEL);
  }

  override configureRoutes(): express.Application {
    this.app
      .route(`/model/:selbriId`)
      .get(bound(GetElementControllerService))
      .put(bound(SaveElementControllerService));
    return this.app;
  }
}
