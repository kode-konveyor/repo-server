import type express from "express";
import { HTTP_CREATED } from "../Constants.js";
import { SaveElementService } from "../dataAccess/SaveElementService.js";

export class SaveElementControllerService {
  constructor(
    readonly saveElement = SaveElementService.prototype.saveElement
  ) {}

  saveElementController(req: express.Request, res: express.Response): void {
    res.status(HTTP_CREATED).send(this.saveElement(req.body));
  }
}
