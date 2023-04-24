import { SELBRI_SCHEMA } from "./Constants.js";
import { mongooseInstance } from "./mongooseInstance.js";

const mongoose = mongooseInstance.getMongoose();

const selbriSchema = new mongoose.Schema({
  representation: String,
});

export const SelbriDAO = mongoose.model(SELBRI_SCHEMA, selbriSchema);
