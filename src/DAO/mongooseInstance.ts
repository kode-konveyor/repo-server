import mongoose from "mongoose";

const MONGOOSE_URL = "mongodb://localhost:27017/api-db";
const CONNECTED_MESSAGE = "MongoDB is connected";
const retrySeconds = 5;

const mongooseOptions = {
  useNewUrlParser: true,
  useUnifiedTopology: true,
  serverSelectionTimeoutMS: 5000,
};

class Mongoose {
  private count = 0;

  getMongoose(): typeof mongoose {
    return mongoose;
  }

  async connect(): Promise<this> {
    try {
      await mongoose.connect(MONGOOSE_URL, mongooseOptions);
      console.log(CONNECTED_MESSAGE);
    } catch (err) {
      console.log(
        `MongoDB connection unsuccessful (will retry #${++this
          .count} after ${retrySeconds} seconds):`,
        err
      );
      // eslint-disable-next-line @typescript-eslint/no-misused-promises
      setTimeout(this.connect, retrySeconds * 1000);
    }
    return this;
  }

  async disconnect(): Promise<void> {
    await mongoose.disconnect();
  }
}

export const mongooseInstance = await new Mongoose().connect();
